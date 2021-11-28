import React from "react";
import Header from "./components/Header";
import About from "./routes/about/About";
import TicketViewerPage from "./routes/tickets/TicketViewerPage";
import Home from "./routes/home/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Routes, Route, Link } from "react-router-dom";


export default function App() {
  return <React.Fragment>
  <Header/>
  <Routes>
          <Route path="/about" element={<About />} />
          <Route path="/tickets" element={<TicketViewerPage />} />
          <Route path="/" element={<Home />} />

      </Routes>

  </React.Fragment>;
}