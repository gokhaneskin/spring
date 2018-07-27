import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import Books from './Books';
import Auhtors from './Authors';
import './App.css';
import Authors from './Authors';
import Home from './Home'

class App extends Component {
  render() {
    return (
      <Router>
      <body>
        <nav class="navbar navbar-inverse">
        
              <div class="container-fluid">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>                        
                  </button>
                  <a class="navbar-brand" href="#">Book Store</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                  <ul class="nav navbar-nav">
                    <li class="active"><Link to={'/'}>Home</Link></li>
                    <li><Link to={'/books'}>Books</Link></li>
                    <li><Link to={'/authors'}>Auhtors</Link></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                  </ul>
                </div>
              </div>
         
        </nav>
        <div class="container-fluid bg-3 text-center"> 
        <Switch>
         <Route  exact path='/' component={Home}/>
          <Route path='/books' component={Books}/>
          <Route path='/authors' component={Authors}/>
        </Switch>   
      </div>
    </body>
    </Router>
    );
  }
}

export default App;
