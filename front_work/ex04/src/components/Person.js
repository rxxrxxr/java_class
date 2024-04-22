import React, { useState } from "react";
import axios from "axios";

const getPerson = async () => {
  console.log("getPerson");
  // await 키워드는 통신을 시작하게 되면 시간이 걸리는데 통신 끝날때까지 기다려서 result에 담겠다
  // Match.random() 0~1까지 랜덤

  const id = parseInt(Math.random() * 3 + 1);
  const result = await axios.get(`http://localhost:8080/person/one/${id}`);
  console.log(result);
  return result.data;
};

const Person = ({ name, age: paramage }) => {
  console.log("Person");
  const [age, setAge] = useState(paramage);

  const addAge = () => {
    setAge(age + 1);
  };
  const subAge = () => {
    setAge(age - 1);
  };
  return (
    <>
      <h1>Person</h1>
      <h2>이름 = {name}</h2>
      <h2>나이 = {age}</h2>
      <button onClick={addAge} variant="contained">나이증가</button>
      <button onClick={subAge}>나이감소</button>
      <button
        onClick={async () => {
          const data = await getPerson();
          setAge(data.age);
        }}
      >
        가져오기
      </button>
      
    </>
  );
};

export default Person;
