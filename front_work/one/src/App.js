import React, { useState } from "react";
import "./App.css";
import Menu from "./Menu";

function App() {
  const [isMenuVisible, setIsMenuVisible] = useState(false);
  return (
    <div className="App">
      <header
        className="App-header"
        onMouseEnter={() => setIsMenuVisible(true)}
        onMouseLeave={() => setIsMenuVisible(false)}
      >
        <h1>Welcome to Chicken Order App</h1>
      </header>
      <main>
        <Menu />
      </main>
    </div>
  );
}

export default App;
