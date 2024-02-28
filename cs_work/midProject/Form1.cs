using midProject.todo;
using midProject.user;
using System;
using System.Windows.Forms;

namespace midProject
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.IsMdiContainer = true;
        }

        private void 사용자관리ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            UserForm userForm = new UserForm();
            userForm.MdiParent = this;
            userForm.Show();
        }

        private void 할일관리ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TodoForm todoForm = new TodoForm();
            todoForm.Show();
        }

        private void 종료ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Dispose();
        }
    }
}
