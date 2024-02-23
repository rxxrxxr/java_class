using _0223_autoid_crud.DB;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Windows.Forms;

namespace _0223_autoid_crud
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.comboBox1.Items.AddRange(new object[] { "남자", "여자" });
        }

        private void Insert(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(FirstNameTextBox.Text.Trim())
                    || string.IsNullOrEmpty(LastNameTextBox.Text.Trim()))
            {
                MessageBox.Show("이름을 입력하세요", "경고", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }

            string gender = "남자";
            if (comboBox1.SelectedItem != null)
            {
                gender = comboBox1.SelectedItem.ToString();
            }

            string sql = $"insert into tb_smart_crud " +
                $"values " +
                $"(tb_smart_seq.nextval," +
                $"'{FirstNameTextBox.Text}'," +
                $"'{LastNameTextBox.Text}'," +
                $"'{gender}')";

            CRUD.con.Open();
            CRUD.cmd = new OracleCommand(sql, CRUD.con);
            CRUD.cmd.Parameters.Clear();
            //CRUD.cmd.Parameters.AddWith();
            CRUD.cmd.ExecuteNonQuery();
            CRUD.con.Close();

            MessageBox.Show("저장되었습니다");
        }
    }
}
