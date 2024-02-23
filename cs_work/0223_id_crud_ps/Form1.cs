using System;
using System.Windows.Forms;
using _0223_id_crud_ps.DB;
using Oracle.ManagedDataAccess.Client;

namespace _0223_id_crud_ps
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string sql = $"insert into Member values (member_seq.nextval,'{TextBoxEmail.Text}','{TextBoxName.Text}','{TextBoxPassword.Text}')";

            CRUD.con.Open();
            CRUD.cmd = new OracleCommand(sql, CRUD.con);
            CRUD.cmd.Parameters.Clear();
            CRUD.cmd.ExecuteNonQuery();
            CRUD.con.Close();

            MessageBox.Show("저장되었습니다");

        }
    }
}
