import React from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./App.css";
import { CheckoutPage } from "./Checkout.jsx";
import { SuccessPage } from "./Success.jsx";
import { FailPage } from "./Fail.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    // 결제요청
    element: <CheckoutPage />,
  },
  {
    // 결제성공
    path: "success",
    element: <SuccessPage />,
  },
  {
    // 결제실패
    path: "fail",
    element: <FailPage />,
  },
]);

export function App() {
  return <RouterProvider router={router} />;
}
