import React, { Component } from 'react';
import './App.css';

class App extends Component {

  constructor(props) {

    super(props);

    this.username = 'santosh';
    this.password = 'santosh';

    this.state = {
      isLoaded: false,
      loggedIn: false,
      username: null
    }

    this.doLogin = this.doLogin.bind(this);
    this.findCurrentUser = this.findCurrentUser.bind(this);
    this.updateUserName = this.updateUserName.bind(this);
    this.updatePassword = this.updatePassword.bind(this);

  }

  updateUserName(event) {
    this.username = event.target.value;
  }

  updatePassword(event) {
    this.password = event.target.value;
  }


  componentDidMount() {
    this.findCurrentUser();
  }

  findCurrentUser() {
    fetch('http://localhost:8085/api/user/identity')
      .then(res => res.json())
      .then((result) => {
        console.log("Result found from server : ", result);
      }, (error) => {
        console.log("error occured : ");
      });
  }

  doLogin() {
    if (this.username === '' || this.password === '') {
      alert("User name and password can't be empty");
      return;
    }
    var body = {
      username: this.username,
      password: this.password
    }
    console.log("Login body : ", body);
    fetch('http://localhost:8085/login', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: body
    })
      .then(res => res.json())
      .then((result) => {
        console.log("Result found from server : ", result);
      }, (error) => {
        console.log("error occured : ", error);
      });
  }

  render() {
    return (
      <div className="App">
        <div className="loaderContainer">
          <p>Loading...</p>
        </div>
        <div className="mainContainer">
          <div className="loginContainer" >
            <input type="text" placeholder="username" onChange={this.updateUserName} defaultValue={this.username} />
            <input type="password" placeholder="password" onChange={this.updatePassword} defaultValue={this.password} />
            <button onClick={this.doLogin}>LOGIN</button>
          </div>
          <div className="userDetailContainer">
            <p className="header">You are currently logged in.</p>
            <p className="userDetail">User Name : {this.state.username}</p>
          </div>
        </div>
      </div>
    );
  }

}

export default App;
