using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace midProject.database
{
    internal class DBINFO
    {
        public static string dbstr = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=localhost)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=userTodo;Password=1234;";
        public static OracleConnection connection = null;

        public static OracleConnection openConnect()
        {
            if (connection == null)
            {
                connection = new OracleConnection(dbstr);
                connection.Open();

            }
            else
            {
                connection.Open();
            }
            return connection;

        }
        public static void closeConnect()
        {
            if (connection != null)
            {
                connection.Close();
                connection.Dispose();
                connection = null;
            }
        }

    }
}
