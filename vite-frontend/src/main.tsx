import React from 'react';
import ReactDOM from 'react-dom/client';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import App from './App.tsx';
import './index.css';
import ConsoleCardInfo from './routes/ConsoleCardInfo/index.tsx';
import ConsoleCardList from './routes/ConsoleCardList/index.tsx';
import ConsoleForm from './routes/ConsoleForm/index.tsx';
import ConsoleList from './routes/ConsoleList/index.tsx';
import GameCardList from './routes/GameCardList/index.tsx';
import GameForm from './routes/GameForm/index.tsx';
import GameList from './routes/GameList/index.tsx';
import Home from './routes/Home/index.tsx';
import GameListByConsole from './routes/GameListByConsole/index.tsx';

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
        path: "console/insert",
        element: <ConsoleForm />,
      },
      {
        path: "game/insert",
        element: <GameForm />,
      },
      {
        path: "game/list",
        element: <GameList />,
      },
      {
        path: "console/list",
        element: <ConsoleList />,
      },
      {
        path: "game/card/list",
        element: <GameCardList />,
      },
      {
        path: "console/card/list",
        element: <ConsoleCardList />,
      },
      {
        path: "console/:id",
        element: <ConsoleCardInfo />,
      },
      {
        path: "game/console/:id",
        element: <GameListByConsole />,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
