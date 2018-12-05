import React, { Component } from 'react';
import Header from './header.js'
 import Main from './main.js'
 import './App.css';

class App extends Component {
  render() {
    return (
        <div>
        <Header />
        <Main />
      </div>
    );
  }
}

export default App;