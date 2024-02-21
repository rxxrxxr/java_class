using ex0220.datebase;
using ex0220.file;
using Oracle.ManagedDataAccess.Client;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace ex0220
{
    public partial class Form1 : Form
    {
        FileControl fileControl = new FileControl();
        FileTBDataBase ftdb = new FileTBDataBase();

        private string seletedString = "";

        //List<string> list = new List<string>();
        public Form1()
        {
            InitializeComponent();

            //List<string> list = fileControl.read();
            List<string> list = ftdb.read();
            listBox1.DataSource = null;
            listBox1.DataSource = list;
        }

        private void 불러오기(object sender, EventArgs e)
        {
            //List<string> list = fileControl.read();
            List<string> list = ftdb.read();
            listBox1.DataSource = null;
            listBox1.DataSource = list;
        }

        private void 파일쓰기(object sender, EventArgs e)
        {
            if (textBox1.Text == "")
            {
                MessageBox.Show("글자를 입력하세요");
                return;
            }

            //list.Add(textBox1.Text);
            //fileControl.write(textBox1.Text, list);

            ftdb.insert(textBox1.Text);
            List<string> list = ftdb.read();

            listBox1.DataSource = null;
            listBox1.DataSource = list;
            textBox1.Text = "";
            //listBox1.Items.Add("추가");
        }

        private void 수정하기(object sender, EventArgs e)
        {
            MessageBox.Show("수정");

            if (textBox1.Text == "")
            {
                MessageBox.Show("글자를 입력하세요");
                return;
            }

            string updateStr = textBox1.Text;

            ftdb.update(seletedString, updateStr);
            // select 버튼 누른거 이벤트 발생
            button1.PerformClick();
            textBox1.Text = "";
            // 불러오기 함수 호출
            // 불러오기 (null, null);

        }

        private void 삭제하기(object sender, EventArgs e)
        {
            string connectionString = "Data Source=(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.0.38)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=xe)));User Id=hr;Password=1234;";
            OracleConnection con = new OracleConnection(connectionString);
            con.Open();

            OracleCommand oracleCommand = new OracleCommand($"delete from filetb where str = '{textBox1.Text}'", con);
            oracleCommand.ExecuteNonQuery();

            con.Close();

            MessageBox.Show("삭제");
        }
        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Console.WriteLine(listBox1.SelectedIndex);
            Console.WriteLine(listBox1.SelectedItem);
            if (listBox1.SelectedItem != null)
            {
                textBox1.Text = listBox1.SelectedItem.ToString();
                seletedString = listBox1.SelectedItem.ToString();
                MessageBox.Show("글자 수정" + seletedString);
            }
        }
    }
}
