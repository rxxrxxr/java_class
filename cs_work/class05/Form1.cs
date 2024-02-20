namespace class05
{
    class Car
    {
        public String Name { get; set; }

    }
    public partial class Form1 : Form
    {
        private Label label1;
        int y = 10;
        List<Car> list = new List<Car>();
        

        public Form1()
        {
            InitializeComponent();

            Car car1 = new Car() { Name = "A자동차" };
            Car car2 = new Car() { Name = "B자동차" };

            list.Add(car1);
            list.Add(car2);

            foreach (var car in list) 
            {
                Console.WriteLine(car);
                Make_Label(10, y, car.Name);
                y += 40;
            }

        }
        public void Make_Label(int x, int y, string text)
        {
            label1 = new Label();

            label1.AutoSize = true;
            label1.Location = new Point(x, y);
            label1.TabIndex = 0;
            label1.Text = text;
            label1.Font = new Font("배달의민족 도현", 14.2499981F, FontStyle.Bold, GraphicsUnit.Point, 129);

            Controls.Add(label1);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Make_Label(10, y = y + 40, textBox1.Text);
            Console.WriteLine(textBox1.Text);
            textBox1.Text = "";

        }

        private void textBox1_KeyUp(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                button1_Click(null, null);
            }
        }
    }
}
