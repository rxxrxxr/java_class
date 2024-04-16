import World from "./World";
import "./Hello.css";

export default function Hello() {
  return (
    <div>
      <h1
        style={{
          color: "#f00",
          borderRight: "2px solid #000",
          marginBottom: "50px",
          opacity: 0.5,
        }}
      >
        Hello
      </h1>
      <div className="box">Hello</div>
    </div>
  );
}
