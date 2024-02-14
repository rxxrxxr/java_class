using WinFormsApp7.aa;

namespace WinFormsApp7
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // showDialog - 새창, show - 기존창도 같이 뜸
            Hide();
            MessageBox.Show("form2");
            new Form2().ShowDialog();
            Show();

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Hide();
            MessageBox.Show("form3");
            new Form3().ShowDialog();
            Show();

        }
    }
}
