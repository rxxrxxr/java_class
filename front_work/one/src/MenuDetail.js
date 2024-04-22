import React from 'react';
import './App.css';

function App() {
  return (
    <div className="container">
      <header>
        <h1>ONEZO TONGDAK</h1>
        <nav>
          <button>메뉴</button>
          <button>커리</button>
          <button>사이드</button>
          <button>음료</button>
          <button>소스</button>
        </nav>
      </header>
      <main>
        <div className="content">
          <div className="product-card">
            <img src="aaa.jpg" alt="원조 후라이드" />
            <h2>원조 후라이드</h2>
            <p>18,000원</p>
            <p>* 본 이미지는 실제와 다를 수 있으며 가맹점 상황에 따라 가격이 상이 할 수 있습니다.</p>
            <div className="quantity-control">
              <button>-</button>
              <span>1</span>
              <button>+</button>
            </div>
            <button className="add-to-cart">주문하기</button>
          </div>
          <div className="nutrition-info">
            <h3>영양성분 정보</h3>
            <table>
              <tbody>
                <tr>
                  <th>1회 제공량</th>
                  <td>100g</td>
                </tr>
                <tr>
                  <th>칼로리(Kcal)</th>
                  <td>250.54</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </main>
    </div>
  );
}

export default App;