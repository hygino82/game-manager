import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import App from "./App";
import GameCardList from "./components/GameCardList";
import GameTable from "./components/GameTable";
import "./index.css";
import ConsoleForm from "./routes/ConsoleForm";
import ConsoleList from "./routes/ConsoleList";
import GameInsertForm from "./routes/GameInsertForm";
import Home from "./routes/Home";


const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "/game-insert",
        element: <GameInsertForm />,
      },
      {
        path: "/console-list",
        element: <ConsoleList />,
      },
      {
        path: "/card-list",
        element: <GameCardList />,
      },
      {
        path: "/game-list",
        element: <GameTable />,
      },
      {
        path: "/console-form",
        element: <ConsoleForm />,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
