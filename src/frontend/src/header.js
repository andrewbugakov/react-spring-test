import React from 'react';


// import ReactDOM from 'react-dom';
import Navbar from 'react-bootstrap/lib/Navbar';
import Nav from 'react-bootstrap/lib/Nav';

import NavItem from 'react-bootstrap/lib/NavItem';

class Header extends React.Component{
    render(){
        return (
        <Navbar inverse collapseOnSelect>
  <Navbar.Header>
    <Navbar.Brand>
      <a href="/">Money management</a>
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