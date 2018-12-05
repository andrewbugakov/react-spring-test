import React from 'react';
import 'bootstrap/dist/js/bootstrap.min';
import 'jquery/dist/jquery.slim.min';

// import ReactDOM from 'react-dom';
import Table from 'react-bootstrap/lib/Table';
import Button from 'react-bootstrap/lib/Button';


import '../node_modules/bootstrap/dist/css/bootstrap.min.css';


class Currencies extends React.Component{
    state = {
        posts: []
    }

    componentDidMount() {
        axios.get(`/currencies`)
            .then(res => {
                const posts = res.data;
                console.info(posts);

                this.setState({ posts });
            });
    }

    render(){
        return (
            <div>
                <Button class="btn-primary">Create currencies</Button>
                <Table responsive>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Table heading</th>
                        <th>Table heading</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.posts.map(post =>
                        <tr>
                            <td>{post.id}</td>
                            <td>{post.title}</td>
                        </tr>
                    )}
                    </tbody>
                </Table>;
            </div>
        );}
}
export default Currencies;