﻿using Oracle.ManagedDataAccess.Client;

namespace _0223_id_crud_ps.DB
{
    public class CRUD
    {
        private static string getConnection()
        {
            string dbstr = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=hr;Password=1234;";

            return dbstr;
        }

        public static OracleConnection con = new OracleConnection( getConnection() );
        public static OracleCommand cmd = new OracleCommand();
        public static string sql = "";

    }
}
