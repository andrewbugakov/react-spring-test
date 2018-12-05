import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';

class FetchDemo extends React.Component {
  state = {
    posts: []
  }

  componentDidMount() {
    axios.get(`localhost:8080/currencies`)
    .then(res => {
      const posts = res;
      console.info(posts);

      this.setState({ posts });
    });
  }

  render() {
    return (
      <div>
        
        <h1>/r/reactjs</h1>
        <ul>
          {this.state.posts.map(post =>
            <li key={post.id}>{post.title}</li>
          )}
        </ul>
      </div>
    );
  }
}

ReactDOM.render(
  <FetchDemo subreddit="reactjs"/>,
  document.getElementById('root')
);
export default FetchDemo;