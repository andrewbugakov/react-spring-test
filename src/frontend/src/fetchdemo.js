import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';

class FetchDemo extends React.Component {
  state = {
    posts: []
  }

  componentDidMount() {
    axios.get(`/currencies`)
    .then(res => {
      const posts = res;
      console.info(posts.data);

      this.setState({ posts });
    });
  }

  render() {
    return (
      <div>
        
        <h1>/r/reactjs</h1>
        <ul>
          {this.state.posts.map(post =>
            <li key={post.id}>{post.name}</li>
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