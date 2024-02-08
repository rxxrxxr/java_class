using Oracle.ManagedDataAccess.Client;
using System.Data;

namespace WinFormsApp2
{
    public partial class Form1 : Form
    {
        string connectionString = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.0.38)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=hr;Password=1234;";
        OracleConnection conn;
        OracleCommand cmd;

        public Form1()
        {
            InitializeComponent();
            // �ּ� ����Ű ctrl + k + c
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                conn = new OracleConnection(connectionString);

                conn.Open(); // DB ����

                DataSet dataSet = new DataSet();
                string sql = "select * from emp";

                OracleDataAdapter adapter = new OracleDataAdapter();
                adapter.SelectCommand = new OracleCommand(sql, conn);
                adapter.Fill(dataSet);

                // �߰�
                dataGridView1.DataSource = dataSet.Tables[0];

                conn.Close(); // DB �ݱ�

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.StackTrace);
            }

        }
        private void button2_Click(object sender, EventArgs e)
        {

        }
    }
}
