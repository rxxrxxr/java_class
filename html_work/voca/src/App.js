import "./App.css";
import Hello from "./component/Hello";
import Welcome from "./component/Welcome";
import React from "react";

function App() {
  const name = "Tom";
  const naver = {
    name: "네이버",
    url: "https://naver.com",
  };
  const google = {
    name: "구글",
    url: "https://google.com",
  };
  return (
    <div className="App">
      <Hello />
      <Welcome />
      <h1
        style={{
          color: "#f0f",
          backgroundColor: "green",
        }}
      >
        Hello, {name}.<p>{2 + 3}</p>
      </h1>
      <a href={naver.url}>{naver.name}</a>
      <br />
      <a href={google.url}>{google.name}</a>
      <div className="box"></div>
    </div>
  );
}

export default App;
