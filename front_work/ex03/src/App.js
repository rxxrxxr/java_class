import "./App.css";
import BasicLayout from "./layout/BasicLayout";
import { Route, Routes } from 'react-router-dom';
import Home from "./pages/Home";
import About from "./pages/About";
import Contact from "./pages/Contact";

function App() {
  return (
    <div className="App">
        <BasicLayout>
          <Routes>
            <Route path="/" element={<Home></Home>} />
            <Route path="/about" element={<About></About>} />
            <Route path="/contact" element={<Contact></Contact>} />
          </Routes>
        </BasicLayout>
    </div>
  );
}

export default App;
