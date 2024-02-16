namespace WinFormsApp11
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            //label3.Font = new Font("����ǹ��� ����", 14.2499981F, FontStyle.Bold, GraphicsUnit.Point, 129);

            foreach (Control control in this.Controls) 
            { 
                Console.WriteLine(control);

                if (control is Panel) 
                {
                    // ���� ��Ȳ�� �߻��ϴ��� ���� �ȵ�
                    Panel panel = control as Panel;
                    foreach(Control control1 in panel.Controls) 
                    {
                        control1.Text = "���� �ٲٱ�";
                    }
                }

                control.Text = "���ڹٲٱ�";
                control.Font = label3.Font = new Font("����ǹ��� ����", 14.2499981F, FontStyle.Bold, GraphicsUnit.Point, 129);
                if (control is Button) 
                {
                    Button button = control as Button;
                    control.AutoSize = true;
                }

            }
        }
    }
}
