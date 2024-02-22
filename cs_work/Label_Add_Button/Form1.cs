using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace Label_Add_Button
{
    public partial class Form1 : Form
    {
        List<int> ints = new List<int>();
        int size = 3;
        public Form1()
        {
            InitializeComponent();

            Console.WriteLine();
            abbButtons();
            //ints.Add(11);
            //ints.Add(22);

            

        }

        private void Button_Click1(object sender, EventArgs e)
        {
            MessageBox.Show("함수연결 되나");

        }

        #region 버튼추가하는 함수
        private void abbButtons()
        {
            Random random = new Random();
            for (int i = 0; i < 5; i++)
            {
                string randomstr = random.Next(100).ToString();
                // 추가하는 버튼
                Button button = new Button();
                button.Text = randomstr;
                button.Font = new System.Drawing.Font("경기천년제목 Bold", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
                button.AutoSize = true;
                button.Location = new Point(80 + (i * 100), 230);
                button.Click += Button_Click;
                //button.Click += new System.EventHandler(Button_Click1);
                //button.Click += (aa, bb) =>
                //{
                //    MessageBox.Show("람다 연결");
                //};
                Controls.Add(button);
                // 삭제하는 버튼
                Button button1 = new Button();
                button1.Text = randomstr;
                button1.Font = new System.Drawing.Font("경기천년제목 Bold", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
                button1.AutoSize = true;
                button1.Location = new Point(80 + (i * 100), 270);
                button1.Click += Button1_Click;
                
                //button1.Click += (sender, e) =>
                //{
                //    Button temp = sender as Button;
                //    int itemp = int.Parse(temp.Text);
                //    ints.Remove(itemp);
                //    //0번째 삭제
                //    //ints.Remove(0); 
                //    setLabelList();
                //};

                Controls.Add(button1);
            }

            setLabelList();
        }
        private void Button_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int temp = int.Parse(btn.Text);
            ints.Add(temp);

            setLabelList();
            //MessageBox.Show("Test" + btn.Text);

        }
        private void Button1_Click(object sender, EventArgs e)
        {
            Button temp = sender as Button;
            int itemp = int.Parse(temp.Text);
            ints.Remove(itemp);
            //ints.RemoveAt(0);
            setLabelList();

        }
        #endregion

        private void setLabelList()
        {
            string result = "";
            for (int i = 0; i < ints.Count; i++)
            {
                if (ints.Count != (i + 1))
                    result = result + (ints[i] + ", ");
                else
                    result = result + ints[i];
                //Console.WriteLine(i);
            }
            label2.Text = result;
        }

        private void Form1_Load(object sender, System.EventArgs e)
        {
            //MessageBox.Show("Test");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            
        }
    }
}
