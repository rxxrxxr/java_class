

namespace WinFormsApp3
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            button1 = new Button();
            label1 = new Label();
            textBox1 = new TextBox();
            button2 = new Button();
            button3 = new Button();
            button4 = new Button();
            button5 = new Button();
            tb_num1 = new TextBox();
            tb_num2 = new TextBox();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            lb_result = new Label();
            SuspendLayout();
            // 
            // button1
            // 
            button1.Location = new Point(234, 6);
            button1.Name = "button1";
            button1.Size = new Size(108, 64);
            button1.TabIndex = 0;
            button1.Text = "button1";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(62, 31);
            label1.Name = "label1";
            label1.Size = new Size(32, 15);
            label1.TabIndex = 2;
            label1.Text = "label";
            // 
            // textBox1
            // 
            textBox1.Location = new Point(107, 28);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(121, 23);
            textBox1.TabIndex = 3;
            // 
            // button2
            // 
            button2.Font = new Font("경기천년제목 Bold", 12F, FontStyle.Bold);
            button2.Location = new Point(680, 13);
            button2.Name = "button2";
            button2.Size = new Size(108, 64);
            button2.TabIndex = 4;
            button2.Text = "더하기";
            button2.Click += button2_Click;
            // 
            // button3
            // 
            button3.Font = new Font("경기천년제목 Bold", 12F, FontStyle.Bold);
            button3.Location = new Point(680, 83);
            button3.Name = "button3";
            button3.Size = new Size(108, 64);
            button3.TabIndex = 5;
            button3.Text = "빼기";
            button3.Click += button3_Click;
            // 
            // button4
            // 
            button4.Font = new Font("경기천년제목 Bold", 12F, FontStyle.Bold);
            button4.Location = new Point(680, 153);
            button4.Name = "button4";
            button4.Size = new Size(108, 64);
            button4.TabIndex = 6;
            button4.Text = "곱하기";
            button4.Click += button4_Click;
            // 
            // button5
            // 
            button5.Font = new Font("경기천년제목 Bold", 12F, FontStyle.Bold);
            button5.Location = new Point(680, 223);
            button5.Name = "button5";
            button5.Size = new Size(108, 64);
            button5.TabIndex = 7;
            button5.Text = "나누기";
            button5.Click += button5_Click;
            // 
            // tb_num1
            // 
            tb_num1.Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right;
            tb_num1.Font = new Font("경기천년제목 Bold", 14.25F, FontStyle.Bold);
            tb_num1.Location = new Point(572, 112);
            tb_num1.Name = "tb_num1";
            tb_num1.Size = new Size(79, 26);
            tb_num1.TabIndex = 8;
            tb_num1.TextAlign = HorizontalAlignment.Center;
            // 
            // tb_num2
            // 
            tb_num2.Anchor = AnchorStyles.Top | AnchorStyles.Bottom | AnchorStyles.Left | AnchorStyles.Right;
            tb_num2.Font = new Font("경기천년제목 Bold", 14.25F, FontStyle.Bold);
            tb_num2.Location = new Point(572, 160);
            tb_num2.Name = "tb_num2";
            tb_num2.Size = new Size(79, 26);
            tb_num2.TabIndex = 9;
            tb_num2.TextAlign = HorizontalAlignment.Center;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("경기천년제목 Bold", 14.25F, FontStyle.Bold);
            label2.Location = new Point(487, 115);
            label2.Name = "label2";
            label2.Size = new Size(79, 19);
            label2.TabIndex = 10;
            label2.Text = "첫번째 수";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("경기천년제목 Bold", 14.25F, FontStyle.Bold);
            label3.Location = new Point(487, 163);
            label3.Name = "label3";
            label3.Size = new Size(79, 19);
            label3.TabIndex = 11;
            label3.Text = "두번째 수";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("경기천년제목 Bold", 14.25F, FontStyle.Bold);
            label4.Location = new Point(504, 223);
            label4.Name = "label4";
            label4.Size = new Size(42, 19);
            label4.TabIndex = 12;
            label4.Text = "결과";
            // 
            // lb_result
            // 
            lb_result.AutoSize = true;
            lb_result.Font = new Font("경기천년제목 Bold", 14.25F, FontStyle.Bold);
            lb_result.Location = new Point(590, 223);
            lb_result.Name = "lb_result";
            lb_result.Size = new Size(42, 19);
            lb_result.TabIndex = 13;
            lb_result.Text = "결과";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(lb_result);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(tb_num2);
            Controls.Add(tb_num1);
            Controls.Add(button5);
            Controls.Add(button4);
            Controls.Add(button3);
            Controls.Add(button2);
            Controls.Add(textBox1);
            Controls.Add(label1);
            Controls.Add(button1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }






        #endregion

        private Button button1;
        private Label label1;
        private TextBox textBox1;
        private Button button2;
        private Button button3;
        private Button button4;
        private Button button5;
        private TextBox tb_num1;
        private TextBox tb_num2;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label lb_result;
    }
}
