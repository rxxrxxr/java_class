﻿using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
namespace ex0220.datebase
{
    internal class FileTBDataBase
    {
        private static string connectionString = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.0.38)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=hr;Password=1234;";
        private static OracleConnection con = null;

        public static OracleConnection connection()
        {
            if (con == null)
            {
                con = new OracleConnection(connectionString);
                con.Open();
            }
            else
            {
                con.Open();
            }
            return con;
        }

        public void insert(string text)
        {
            OracleConnection con = connection();

            string sql = "insert into FILETB values (:value1)";

            using (OracleCommand command = new OracleCommand(sql, con))
            {
                command.Parameters.Add(":value1", text);
                int rowId = command.ExecuteNonQuery();
                Console.WriteLine($" {rowId} 행을 삽입했습니다");

            }
            con.Close();
        }

        internal List<string> read()
        {
            List<string> list = new List<string>();
            OracleConnection con = connection();

            string sql = "select * from filetb";

            using (OracleCommand command = new OracleCommand(sql, con))
            {
                OracleDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    list.Add(reader.GetString(0));
                }
            }
            


                con.Close();

            return list;
        }
    }
}
