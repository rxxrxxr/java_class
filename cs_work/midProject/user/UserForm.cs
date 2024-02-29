using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace midProject.user
{
    public partial class UserForm : Form
    {
        private static UserForm instance = null;
        private UserDBManager userdbManager = new UserDBManager();
        public static UserForm getInstance()
        {
            if (instance == null || instance.IsDisposed)
            {
                instance = new UserForm();
                return instance;
            }
            else
            {
                return instance;
            }
        }
        public UserForm()
        {
            InitializeComponent();
            LoadData();
        }

        private void LoadData()
        {
            DataTable dataTable = userdbManager.select();
            if (dataTable != null)
            {
                dataGridView1.DataSource = dataTable;
            }
        }

        // insert
        private void button1_Click(object sender, EventArgs e)
        {
            Users users = new Users()
            {
                Email = textBox1.Text,
                Name = textBox2.Text,
                Password = textBox3.Text,
                Addr = textBox4.Text,
            };

            bool result = userdbManager.insert(users);

            if (result)
            {
                MessageBox.Show("저장 완료");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
                textBox4.Text = "";

                LoadData();
            }
            else
            {
                MessageBox.Show("저장 실패");
            }


        }
        // update
        private void button2_Click(object sender, EventArgs e)
        {

        }
        // delete
        private void button3_Click(object sender, EventArgs e)
        {

        }
        // select
        private void button4_Click(object sender, EventArgs e)
        {
            LoadData();
        }
    }
}
