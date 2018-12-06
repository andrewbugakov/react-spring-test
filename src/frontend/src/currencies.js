import React from 'react';
import ReactDOM from 'react-dom';
import Button from 'react-bootstrap/lib/Button';

import axios from 'axios';
import Table from "react-bootstrap/lib/Table";

class Currencies extends React.Component {
    state = {
        posts: []
    }

    componentDidMount() {
        axios.get(`/api/currencies`)
            .then(res => {
                const posts = res.data;
                this.setState({ posts });
            });
    }

    delete(id){
      axios.delete(`/api/currencies/`+id)
            .then(res => {
                
            });
    }

    render() {
        return (
            <>
          <Button class="btn-primary">Create currency</Button>
                <h1>Currencies</h1>
                
                <Table responsive>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th></th>
                        <th></th>

                    </tr>
                    </thead>
                    <tbody>
                    {this.state.posts.map(post =>
                        <tr>
                            <td>{post.id}</td>
                            <td>{post.name}</td>
                            <td>          
                              <Button class="btn-primary">Edit</Button>
                            </td>
                            <td>          
                              <Button class="btn-primary" onClick='this.delete({post.id})'>Delete</Button>
                            </td>
                        </tr>
                    )}
                    </tbody>
                </Table>;
            </>
        );
    }
}

export default Currencies;