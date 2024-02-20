using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        //public void myThread()
        //{
        //    Random random = new Random();
        //    double ran = random.NextDouble();
        //    button1.Text = ran.ToString();
        //    while (true)
        //    {
        //        Thread.Sleep(1000);
        //        button1.Location = new Point(random.Next(700), random.Next(500));
        //    }
        //}

        private void button1_Click(object sender, EventArgs e)
        {
            //Thread thread = new Thread(myThread);
            //thread.Start();

            button1.Text = "동적으로 버튼 생성";
            button1.Width = 400;

            for (int i = 0; i < 10; i++)
            {
                Button button = new Button();
                button.Text = i.ToString();
                this.Controls.Add(button);

                Point point = new Point();
                point.X = 10;
                point.Y = 100 + 40 * i;
                button.Location = point;

                bool visible = new Random().Next(2) == 0 ? true : false;

                Thread.Sleep(10);
                button.Visible = visible;

            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            A a = new A() { x = 10, y = 20 };
            A b = a;

            AA aa = new AA() { x = 10, y = 20 };
            AA bb = aa;

            a.x = 100;
            Console.WriteLine($"a.x = {a.x}");
            Console.WriteLine($"b.x = {b.x}");
            aa.x = 100;
            Console.WriteLine($"aa.x = {aa.x}");
            Console.WriteLine($"bb.x = {bb.x}");


        }

        private void button3_Click(object sender, EventArgs e)
        {
            List<int> list = new List<int>() { 10, 20, 30, 40, 50 };
            foreach (int i in list)
            {
                Console.WriteLine(i);
            }
        }
    }
}
