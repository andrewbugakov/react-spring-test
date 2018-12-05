import React from 'react';
import 'bootstrap/dist/js/bootstrap.min';
import 'jquery/dist/jquery.slim.min';
import axios from 'axios';


// import ReactDOM from 'react-dom';
import Table from 'react-bootstrap/lib/Table';
import Button from 'react-bootstrap/lib/Button';


import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import ReactDOM from "react-dom";
import FetchDemo from "./fetchdemo";


class Currencies extends React.Component{
    state = {
        curr: []
    }

    componentDidMount() {
        axios.get(`/currencies`)
            .then(res => {
                const curr = res.data;
                console.info(curr);

                this.setState({ curr });
            });
    }

    render(){
        return (
            <>
                <Button class="btn-primary">Create currencies</Button>
                <Table responsive>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Table heading</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.curr.map(post =>
                        <tr>
                            <td>{post.id}</td>
                            <td>{post.name}</td>
                        </tr>
                    )}
                    </tbody>
                </Table>;
            </>
        );}
}

export default Currencies;