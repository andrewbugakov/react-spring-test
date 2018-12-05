import React from 'react';
import ReactDOM from 'react-dom';
import FetchDemo from './fetchdemo.js'


import './index.css';

import '../node_modules/jquery/dist/jquery.slim.min.js';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/bootstrap/dist/js/bootstrap.min.js';




ReactDOM.render(
  <FetchDemo subreddit="reactjs"/>,
  document.getElementById('root')
)

