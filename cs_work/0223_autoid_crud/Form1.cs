using _0223_autoid_crud.DB;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Data;
using System.Windows.Forms;


/*
 * insert update delete
 * 
 * ExecuteNonQuery
 * 
 * select
 * 
 * DataAdapter.Fill
 * 
 */
namespace _0223_autoid_crud
{
    public partial class Form1 : Form
    {
        private int autoid = 0;

        public Form1()
        {
            InitializeComponent();
            this.comboBox1.Items.AddRange(new object[] { "남자", "여자" });
            comboBox1.SelectedIndex = 0;
            dataGridView1.AutoSizeColumnsMode = (DataGridViewAutoSizeColumnsMode)DataGridViewAutoSizeColumnMode.Fill;
            //수정 불가
            dataGridView1.ReadOnly = true;
            dataGridView1.AllowUserToAddRows = false;
            select();

        }

        private void cleanControl()
        {
            FirstNameTextBox.Text = string.Empty;
            LastNameTextBox.Text = string.Empty;
            button2.Text = "UPDATE";
            button3.Text = "DELETE";

        }

        private void select(string searchText = "")
        {
            Console.WriteLine(searchText);

            CRUD.con.Open();

            OracleDataAdapter oracleDataAdapter = new OracleDataAdapter();
            string sql = "select * from tb_smart_crud " +
                "where concat(firstname,lastname) like :searchText order by autoid desc";

            OracleCommand oracleCommand = new OracleCommand(sql, CRUD.con);
            oracleCommand.Parameters.Add(":searchText", $"%{searchText}%");

            oracleDataAdapter.SelectCommand = oracleCommand;

            DataSet dataSet = new DataSet();
            oracleDataAdapter.Fill(dataSet);

            dataGridView1.DataSource = dataSet.Tables[0];

            CRUD.con.Close();
            cleanControl();

            if(dataGridView1.Rows.Count > 0)
            {
                this.autoid = int.Parse(dataGridView1.Rows[0].Cells[0].Value.ToString());
            }
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
            CRUD.cmd.Parameters.Add(":firstName", FirstNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":lastName", LastNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":gender", gender);
            //CRUD.cmd.Parameters.AddWith();
            CRUD.cmd.ExecuteNonQuery();
            CRUD.con.Close();

            MessageBox.Show("저장되었습니다");
            select();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (searchText.Text.Equals(""))
                select();
            else
                select(searchText.Text);
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            this.autoid = int.Parse(dataGridView1.CurrentRow.Cells[0].Value.ToString());
            string firstName = dataGridView1.CurrentRow.Cells[1].Value.ToString();
            string lastName = dataGridView1.CurrentRow.Cells[2].Value.ToString();
            string gender = dataGridView1.CurrentRow.Cells[3].Value.ToString();

            FirstNameTextBox.Text = firstName;
            LastNameTextBox.Text = lastName;

            button2.Text = $"UPDATE ({autoid})";
            button3.Text = $"DELETE ({autoid})";

            comboBox1.SelectedItem = gender;

        }
        #region update 버튼 누름
        private void button2_Click(object sender, EventArgs e)
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

            string sql = $"update tb_smart_crud" +
                             " set firstname = :firstName," +
                             "  lastname = :lastName," +
                             "  gender = :gender" +
                            "  where autoid = :autoid";

            CRUD.con.Open();
            CRUD.cmd = new OracleCommand(sql, CRUD.con);
            CRUD.cmd.Parameters.Clear();
            CRUD.cmd.Parameters.Add(":firstName", FirstNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":lastName", LastNameTextBox.Text);
            CRUD.cmd.Parameters.Add(":gender", gender);
            CRUD.cmd.Parameters.Add(":autoid", this.autoid);
            //CRUD.cmd.Parameters.AddWith();
            CRUD.cmd.ExecuteNonQuery();
            CRUD.con.Close();

            MessageBox.Show("저장되었습니다");
            select();
        }
        #endregion

        #region delete 버튼 누름
        private void button3_Click(object sender, EventArgs e)
        {
            if (autoid == 0)
            {
                MessageBox.Show("삭제되는 행을 선택해주세요");
                return;
            }

            string sql = $"delete tb_smart_crud where autoid = :autoid";

            CRUD.con.Open();
            CRUD.cmd = new OracleCommand(sql, CRUD.con);
            CRUD.cmd.Parameters.Clear();
            CRUD.cmd.Parameters.Add(":autoid", this.autoid);
            //CRUD.cmd.Parameters.AddWith();
            CRUD.cmd.ExecuteNonQuery();
            CRUD.con.Close();

            MessageBox.Show("삭제되었습니다");
            select();
        }
        #endregion
    }
}
