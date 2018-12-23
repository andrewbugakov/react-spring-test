import React from 'react'
import { BrowserRouter,Switch, Route } from 'react-router-dom'
import Error404 from './support/404.js'
import HelloComponent from './support/HelloComponent.js';
import Currencies from './currencies/Currencies';
import Currency from './currencies/Currency';
import Incoming from './incoming/Incoming';
import Incomings from './incoming/Incomings';
import IncomingType from './inctype/IncomingType';
import IncomingTypes from './inctype/IncomingTypes';
import Transaction from './transaction/Transaction';
import Transactions from './transaction/Transactions';
import TransactionType from './trtype/TransactionType';
import TransactionTypes from './trtype/TransactionTypes';
import Users from './users/Users';
import User from './users/User';
const Main = () => (
  <main>
      <BrowserRouter>
            <Switch>
            <Route exact path='/' component={HelloComponent}/>
            <Route  path='/currencies' component={Currencies}/>
            <Route  path='/currency' component={Currency}/>
            <Route  path='/incomings' component={Incomings}/>
            <Route  path='/incoming' component={Incoming}/>
            <Route  path='/inctypes' component={IncomingTypes}/>
            <Route  path='/inctype' component={IncomingType}/>

            <Route  path='/transaction' component={Transaction}/>
            <Route  path='/transactions' component={Transactions}/>
            <Route  path='/trtype' component={TransactionType}/>
            <Route  path='/trtypes' component={TransactionTypes}/>
            <Route  path='/users' component={Users}/>
            <Route  path='/user' component={User}/>
            


            <Route component={Error404}/>

        </Switch>
        </BrowserRouter>  
  </main>
)
export default Main
