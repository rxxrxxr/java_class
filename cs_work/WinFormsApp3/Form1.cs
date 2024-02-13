namespace WinFormsApp3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        // ��� ������ ��ũ -> ���� ����� ȹ��ȭ �Ǿ�����
        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show(((Button)sender).ToString());
            MessageBox.Show(textBox1.Text);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            int num1;
            int num2;
            int.TryParse(tb_num1.Text.ToString(), out num1);
            int.TryParse(tb_num2.Text.ToString(), out num2);
            MessageBox.Show("���ϱ� " + (num1 + num2));
            lb_result.Text = (num1 + num2) + "";
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int num1;
            int num2;
            int.TryParse(tb_num1.Text.ToString(), out num1);
            int.TryParse(tb_num2.Text.ToString(), out num2);
            MessageBox.Show("���� " + (num1 - num2));
            lb_result.Text = (num1 - num2) + "";
        }

        private void button4_Click(object sender, EventArgs e)
        {
            int num1;
            int num2;
            int.TryParse(tb_num1.Text.ToString(), out num1);
            int.TryParse(tb_num2.Text.ToString(), out num2);
            MessageBox.Show("���ϱ� " + (num1 * num2));
            lb_result.Text = (num1 * num2) + "";
        }

        private void button5_Click(object sender, EventArgs e)
        {
            try
            {
                int num1;
                int num2;
                int.TryParse(tb_num1.Text.ToString(), out num1);
                int.TryParse(tb_num2.Text.ToString(), out num2);
                MessageBox.Show("������ " + (num1 / num2));
                lb_result.Text = (num1 / num2) + "";
            }
            catch (Exception)
            {

                MessageBox.Show("0���� ������ �����ϴ�");
            }

        }
    }
}
