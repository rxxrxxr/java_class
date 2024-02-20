using ex0220_File_입출력.file;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ex0220_File_입출력
{
    public partial class Form1 : Form
    {

        FileControl fc = new FileControl();

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void 불러오기(object sender, EventArgs e)
        {

        }

        private void 파일쓰기(object sender, EventArgs e)
        {
            listBox1.Items.Add("추가");
        }
    }
}
