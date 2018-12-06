import React from 'react';
import ReactDOM from 'react-dom';
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

    render() {
        return (
            <>

                <h1>Currencies</h1>

                <Table responsive>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Table heading</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.posts.map(post =>
                        <tr>
                            <td>{post.id}</td>
                            <td>{post.name}</td>
                        </tr>
                    )}
                    </tbody>
                </Table>;
            </>
        );
    }
}

export default Currencies;