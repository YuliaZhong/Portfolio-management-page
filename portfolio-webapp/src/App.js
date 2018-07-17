import React, { Component } from 'react';
import './App.css';
import ItemData from './ItemData';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">Portfolio managment webbpage</h1>
        </header>
     <ItemData/>
      </div>
    );
  }
}

export default App;
