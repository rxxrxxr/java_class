using ex0220.datebase;
using ex0220.file;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace ex0220
{
    public partial class Form1 : Form
    {
        FileControl fileControl = new FileControl();
        FileTBDataBase ftdb = new FileTBDataBase();

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
    }
}
