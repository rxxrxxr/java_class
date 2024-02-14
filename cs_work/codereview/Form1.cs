using Oracle.ManagedDataAccess.Client;
using System.Data.OracleClient;


namespace codereview
{
    public partial class Form1 : Form
    {
        string connectionString = "server=192.168.0.38;user=root;password=1234;database=gcw;";
        OracleConnection conn;
        OracleCommand cmd;
        public Form1()
        {
            InitializeComponent();

        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                conn = new OracleConnection(connectionString);
                conn.Open();
                string sql = "select * from member "

                conn.Close();

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
        }
    }
}
