import { ChangeDetectorRef, Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Blog } from 'src/app/models/blog';
import { BlogService } from 'src/app/services/blog.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ViewAllComponent implements OnInit {

  blogs!: Blog[];
  newBlogs!: Blog[];
  public blog!: Observable<Blog>;

  activeId!: number;

  constructor(private changeDetect: ChangeDetectorRef, private service: BlogService, private uServ: UserService, private router: Router) { }

  ngOnInit(): void {
    console.log(localStorage.getItem("current-user") || "")
    this.service.getCurrentUser();
    this.getAllWizards();
  }

  public trackItem(index: number, item: Blog) {
    return `${item.id}-${index}`;
  }

  getAllWizards(){
    this.service.getAllBlogs()
    .subscribe(
      data => {
        console.log(data);
        this.blogs = data;
        this.changeDetect.detectChanges();
        console.log(this.blogs);
      }
    );

    this.blogs = this.newBlogs;
  }

}
