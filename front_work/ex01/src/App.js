import logo from "./aaa.jpg";
import "./App.css";
import React, { useState } from "react";

function App() {
  const [itemNm, setItemNm] = useState("");
  const [price, setPrice] = useState("");

  const newItem = () => {
    console.log("newItem");
    fetch("http://localhost:8080/api/item/new", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((res) => res.json())
      .then((data) => {
        console.log("Success", data);
      });
  };
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <button onClick={newItem}>Additem</button>
        <p>
          itemNm = {itemNm}
          <br/>
          price = {price}
        </p>
        <a
          className="App-link"
          href="https://kauth.kakao.com/oauth/authorize?client_id=ff0937f4b6886da19d90506ef2579de0&redirect_uri=http://localhost:8080/oauth/kakao/callback&response_type=code"
          // target="_blank"
          rel="noopener noreferrer"
        >
          kakaoLogin
        </a>
      </header>
    </div>
  );
}

export default App;
