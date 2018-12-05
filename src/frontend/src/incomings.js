import React from 'react';
import 'bootstrap/dist/js/bootstrap.min';
import 'jquery/dist/jquery.slim.min';

// import ReactDOM from 'react-dom';
import Table from 'react-bootstrap/lib/Table';
import Button from 'react-bootstrap/lib/Button';


import '../node_modules/bootstrap/dist/css/bootstrap.min.css';


class Incomings extends React.Component{
    componentDidMount(){

    }
    render(){
        return (
        <div>
          <Button class="btn-primary">Create Incomings</Button>
          <Table responsive>
  <thead>
    <tr>
      <th>#</th>
      <th>Table heading</th>
      <th>Table heading</th>
      <th>Table heading</th>
      <th>Table heading</th>
      <th>Table heading</th>
      <th>Table heading</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
    </tr>
    <tr>
      <td>2</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
    </tr>
    <tr>
      <td>3</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
      <td>Table cell</td>
    </tr>
  </tbody>
</Table>;
        </div>
        );}
}
export default Incomings;