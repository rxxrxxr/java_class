import React, { useState } from 'react';

const Menu = () => {
  const [order, setOrder] = useState([]);

  const menuItems = [
    { id: 1, name: 'Original Fried Chicken', price: 10000 },
    { id: 2, name: 'Spicy Fried Chicken', price: 11000 },
    { id: 3, name: 'Garlic Fried Chicken', price: 12000 },
    { id: 4, name: 'Soy Sauce Fried Chicken', price: 12000 },
  ];

  const addToOrder = (menuItem) => {
    setOrder([...order, menuItem]);
  };

  return (
    <div>
      <h2>Menu</h2>
      <ul>
        {menuItems.map((item) => (
          <li key={item.id}>
            {item.name} - {item.price}원{' '}
            <button onClick={() => addToOrder(item)}>Add to Order</button>
          </li>
        ))}
      </ul>
      <h2>Order</h2>
      <ul>
        {order.map((item, index) => (
          <li key={index}>
            {item.name} - {item.price}원
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Menu;
