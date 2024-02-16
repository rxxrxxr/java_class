using MySql.Data.MySqlClient;


namespace OrderForm
{
    public partial class Main_form : Form
    {
        string server = "192.168.0.38"; // HeidiSQL 서버 주소
        string database = "BurgerKing"; // 데이터베이스 이름
        string uid = "root"; // 사용자 이름
        string password = "1234"; // 암호

        string connectionString;
        MySqlConnection connection;

        public Main_form()
        {
            InitializeComponent();
        }

        // ----------------------메뉴 선택하면 listview에 보여주기 start ---------------------------
        private void Load_Products_calum(int product_id)
        {
            connectionString = $"SERVER={server};DATABASE={database};UID={uid};PASSWORD={password};"; // DB 접속
            connection = new MySqlConnection(connectionString);
            connection.Open(); // DB 연결 시작
            try
            {
                string query = $"SELECT name, quantity, price FROM products WHERE product_id = {product_id}";
                MySqlCommand command = new MySqlCommand(query, connection);
                MySqlDataReader reader = command.ExecuteReader();

                // ListView에 데이터 추가
                while (reader.Read())
                {
                    string productName = reader.GetString("name");
                    int productPrice = reader.GetInt32("price");

                    ListViewItem existingItem = Burger_Order_Listview.FindItemWithText(productName);

                    if (existingItem != null)
                    {
                        // 이미 존재하는 제품인 경우 price와 quantity를 증가시킴
                        int currentQuantity = int.Parse(existingItem.SubItems[2].Text); // 현재 quantity 가져오기
                        int newQuantity = currentQuantity + 1; // quantity 증가
                        existingItem.SubItems[2].Text = newQuantity.ToString(); // 증가된 quantity 설정

                        int currentPrice = int.Parse(existingItem.SubItems[1].Text); // 현재 price 가져오기
                        int newPrice = currentPrice + productPrice; // price 증가
                        existingItem.SubItems[1].Text = newPrice.ToString(); // 증가된 price 설정
                    }
                    else
                    {
                        // 새로운 제품인 경우 ListView에 추가
                        ListViewItem item = new ListViewItem(productName);
                        item.SubItems.Add(productPrice.ToString());
                        item.SubItems.Add("1"); // quantity를 항상 1로 설정
                        Burger_Order_Listview.Items.Add(item);
                    }

                    Update_Total_Price();

                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("데이터베이스 연결 오류: " + ex.Message);
            }finally
            { 
                // DB 연결 닫기
                if (connection != null && connection.State != System.Data.ConnectionState.Closed)
                {
                    connection.Close();
                }
            }

        }
        private void Btn_Whopper_Click(object sender, EventArgs e) // 와퍼 메뉴 버튼 동작
        {
            Load_Products_calum(1); // product_id가 1인 제품을 DB에서 가져옴

        }
        private void Btn_Whopper_Js_Click(object sender, EventArgs e) // 와퍼 주니어 메뉴 버튼 동작
        {
            Load_Products_calum(2); // product_id가 2인 제품을 DB에서 가져옴
        }
        // ----------------------메뉴 선택하면 listview에 보여주기 start ---------------------------



        // ----------------------listview 목록 삭제하기 start -----------------------------
        private void Delete_Selected_Menu()
        {
            if (Burger_Order_Listview.SelectedItems.Count > 0)
            {
                ListViewItem selectedItem = Burger_Order_Listview.SelectedItems[0];
                int currentQuantity = int.Parse(selectedItem.SubItems[2].Text);
                if (currentQuantity > 1)
                {
                    // quantity가 1 이상인 경우 quantity를 감소시킴
                    currentQuantity--;
                    selectedItem.SubItems[2].Text = currentQuantity.ToString();
                }
                else
                {
                    // quantity가 1인 경우 ListView에서 행을 제거함
                    Burger_Order_Listview.Items.Remove(selectedItem);
                }

                Update_Total_Price();
            }
            else
            {
                MessageBox.Show("취소할 제품을 선택하세요.");
            }
        }
        private void Btn_Cancel_all_Click(object sender, EventArgs e) // 주문 취소를 누르면 listView를 초기화 해준다 (전체 삭제 버튼)
        {
            Burger_Order_Listview.Items.Clear(); 
        }
        private void Btn_Cancel_Selection_Click(object sender, EventArgs e) // 선택 삭제 버튼
        {
            Delete_Selected_Menu();
        }
        // ----------------------listview 목록 삭제하기 end -----------------------------



        // ----------------------총 금액 계산 start--------------------------------
        private void Update_Total_Price()
        {
            int totalPrice = 0;

            foreach (ListViewItem item in Burger_Order_Listview.Items)
            {
                int price = int.Parse(item.SubItems[1].Text); // 제품의 가격
                int quantity = int.Parse(item.SubItems[2].Text); // 제품의 수량
                totalPrice += price * quantity; // 가격 * 수량을 총 가격에 더함
            }

            Lb_Total_Price.Text = totalPrice.ToString(); // 총 금액을 Label에 표시
        }

        // ----------------------총 금액 계산 end----------------------------------

    }
}
