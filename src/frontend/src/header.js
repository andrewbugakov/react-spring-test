import React from 'react';
import 'bootstrap/dist/js/bootstrap.min';
import 'jquery/dist/jquery.slim.min';

// import ReactDOM from 'react-dom';
import Navbar from 'react-bootstrap/lib/Navbar';
import Nav from 'react-bootstrap/lib/Nav';

import NavItem from 'react-bootstrap/lib/NavItem';

import '../node_modules/bootstrap/dist/css/bootstrap.min.css';


class Header extends React.Component{
    render(){
        return (
        <Navbar>
  <Navbar.Header>
    <Navbar.Brand>
      <a href="/">React-Bootstrap</a>
    </Navbar.Brand>
  </Navbar.Header>
  <Nav>
    <NavItem eventKey={1} href="/transactions">
      Transactions
    </NavItem>
    <NavItem eventKey={2} href="/incomings">
      Incomings
    </NavItem>
    <NavItem eventKey={3} href="/inctypes">
      Incoming types
    </NavItem>
    <NavItem eventKey={4} href="/trtypes">
      Transaction types
    </NavItem>
    <NavItem eventKey={5} href="/currencies">
      Currencies
    </NavItem>
    <NavItem eventKey={6} href="/users">
      Users
    </NavItem>
  </Nav>
</Navbar>
        );}
}
export default Header;