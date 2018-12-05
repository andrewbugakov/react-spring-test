import React from 'react'
import { BrowserRouter,Switch, Route } from 'react-router-dom'
import LoginForm from './login.js'
import FetchDemo from './fetchdemo.js'
import Transactions from './transactions.js'
import Incomings from './incomings.js'
import Error404 from './404.js'
// The Main component renders one of the three provided
// Routes (provided that one matches). Both the /roster
// and /schedule routes will match any pathname that starts
// with /roster or /schedule. The / route will only match
// when the pathname is exactly the string "/"
const Main = () => (
  <main>
      <BrowserRouter>
            <Switch>
            <Route exact path='/' component={LoginForm}/>
            <Route path='/fetch' component={FetchDemo} subreddit="reactjs"/>
            <Route path='/transactions' component={Transactions}/>
            <Route path='/incomings' component={Incomings}/>
            <Route component={Error404}/>

        </Switch>
        </BrowserRouter>  
  </main>
)

export default Main
