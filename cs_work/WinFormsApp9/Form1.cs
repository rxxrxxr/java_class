using NAudio.Wave;

namespace WinFormsApp9
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            KeyPreview = true;
        }
        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            Console.WriteLine("����" + e.KeyCode);
            if (e.KeyCode == Keys.Q)
            {
                panel1.Visible = false;
                WaveOutEvent woe = new WaveOutEvent();
                woe.Init(new AudioFileReader(@"D:\Students\cs_work\WinFormsApp7\WinFormsApp7\do\������.mp3"));
                woe.Play();
            }
        }

        private void Form1_KeyUp(object sender, KeyEventArgs e)
        {
            Console.WriteLine("����" + e.KeyCode);
        }
    }
}
