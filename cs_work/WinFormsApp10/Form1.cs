using System.Drawing.Text;

namespace WinFormsApp10
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            foreach (var font in FontLibrary.Families)
            {
                Console.WriteLine(font);
            }

            // panel�ȿ��ִ� ���� ã�Ƽ� �۲��� �ٲ��ش�
            // Controls = ��� ����
            foreach (var con in Controls)
            {
                if (con is Panel)
                {
                    Panel temp = con as Panel;
                    foreach (var subcon in temp.Controls)
                    {
                        if (subcon is Label)
                        {
                            Label temp1 = subcon as Label;
                            temp1.Font = new Font(FontLibrary.Families[0], 15);
                        }
                    }
                }
                Console.WriteLine(con);

                // panel�ۿ� �ִ� �󺧵�
                if (con is Label)
                {
                    Label temp = con as Label;
                    temp.Font = new Font(FontLibrary.Families[0], 15);
                }


            }
        }
    }
}
