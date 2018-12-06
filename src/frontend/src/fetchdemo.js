import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';
import Table from "react-bootstrap/lib/Table";

class FetchDemo extends React.Component {
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
        
        <h1>/r/reactjs</h1>

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

ReactDOM.render(
  <FetchDemo subreddit="reactjs"/>,
  document.getElementById('root')
);
export default FetchDemo;