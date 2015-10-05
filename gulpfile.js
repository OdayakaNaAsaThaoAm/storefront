var gulp = require('gulp');
var sass = require('gulp-sass');
var minifyCSS = require('gulp-minify-css');
var RevAll = require('gulp-rev-all');
var path = require('path');
var argv = require('yargs').argv;
var gzip = require('gulp-gzip');
var jsonTransform = require('gulp-json-transform');
var gutil = require('gulp-util');
var merge = require('merge-stream');
var gulpIgnore = require('gulp-ignore');
var debug = require('gulp-debug');
var runSequence = require('run-sequence');
var shell = require('gulp-shell');
var del = require('del');

gulp.task('sass', function () {
  return gulp.src('./resources/scss/*.scss')
    .pipe(sass({errLogToConsole: true,
                indentedSyntax: true,
                includePaths: require('node-bourbon').includePaths}))
    .pipe(minifyCSS())
    .pipe(gulp.dest('./resources/public/css'));
});

gulp.task('watch', function () {
  return gulp.watch('./resources/scss/*.scss', ['sass']);
});

gulp.task('default', ['sass']);

gulp.task('cljs-build', shell.task(['lein cljsbuild once release']));

gulp.task('copy-release-assets', function () {
  return gulp.src(['./target/release/**'])
    .pipe(gulp.dest('./resources/public/'));
});

gulp.task('cdn', function () {
  if (!argv.host) {
    throw "missing --host";
  }

  // Clean up from last build
  del(['./resources/public/cdn', './resources/rev-manifest.json']);

  var revAll = new RevAll({
    prefix: "//" + argv.host + "/cdn/"
  });

  var sourceMapPath = 'resources/public/js/out/main.js.map'
  var sourceMapStream = gulp.src([sourceMapPath])
      .pipe(jsonTransform(function(data) {
        data["sources"] = data["sources"].map(function(f) {
          return f.replace("\/", "/");
        });
        return data;
      }));

  var fileStream = gulp.src('resources/public/{js,css,images,fonts}/**')
      .pipe(gulpIgnore.exclude("*.map"));

  return merge(fileStream, sourceMapStream)
    .pipe(revAll.revision())
    .pipe(gzip({ append: false }))
    .pipe(gulp.dest('./resources/public/cdn'))
    .pipe(revAll.manifestFile())
    .pipe(gulp.dest('./resources'));
});

gulp.task('compile-assets', function(cb) {
  runSequence('sass', 'cljs-build', 'copy-release-assets', 'cdn', cb);
});
