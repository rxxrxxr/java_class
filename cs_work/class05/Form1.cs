namespace class05
{
    public partial class Form1 : Form
    {
        private Label label1;

        public Form1()
        {
            InitializeComponent();
            Make_Label(10, 10, "�ȳ��ϼ���");
            Make_Label(10, 50, "�������� �� ����");

        }
        public void Make_Label(int x,  int y, string text)
        {
            label1 = new Label();
            
            label1.AutoSize = true;
            label1.Location = new Point(x, y);
            label1.TabIndex = 0;
            label1.Text = text;
            label1.Font = new Font("����ǹ��� ����", 14.2499981F, FontStyle.Bold, GraphicsUnit.Point, 129);

            Controls.Add(label1);
        }

    }
}
